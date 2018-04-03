package projekatISA.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.ProjectionDate;
import projekatISA.domein.ProjectionTerm;
import projekatISA.repository.RepositoryProjectionDate;
import projekatISA.repository.RepositoryProjectionTerm;
import projekatISA.serviceInterface.ProjectionTermServiceInterface;

@Service
public class ProjectionTermService implements ProjectionTermServiceInterface{

	@Autowired
	private RepositoryProjectionTerm repositoryProjectionTerm;
	
	@Autowired
	private RepositoryProjectionDate repositoryProjectionDate;
	
	@Override
	public ProjectionTerm findOne(Long id) {
		ProjectionTerm projectionTerm = repositoryProjectionTerm.findOneById(id);
		return projectionTerm;
	}

	@Override
	public List<ProjectionTerm> getAll() {
		List<ProjectionTerm> projectionTerms = repositoryProjectionTerm.findAll();
		return projectionTerms;
	}

	@Override
	public ProjectionTerm add(ProjectionTerm projectionTerm) {
		
		ProjectionTerm projectionTerm1 = projectionTerm;
		
		Long id = projectionTerm.getProjectiondate().getId();
		ProjectionDate projectionDate = repositoryProjectionDate.findOneById(id);
		Date date =projectionDate.getDate();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		String dateee = sdf2.format(date);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
		String time = sdf3.format(projectionTerm.getTerm());
	
		String ceo = dateee+" "+time;
		
			
		DateFormat formatter;
		Date newDate;
		formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			newDate = formatter.parse(ceo);
			projectionTerm1.setTerm(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return repositoryProjectionTerm.save(projectionTerm1);
	}

}
