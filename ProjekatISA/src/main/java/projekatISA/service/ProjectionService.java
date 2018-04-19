package projekatISA.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.Projection;
import projekatISA.domein.ProjectionDate;
import projekatISA.repository.RepositoryProjection;
import projekatISA.serviceInterface.ProjectionServiceInterface;

@Service
public class ProjectionService implements ProjectionServiceInterface{

	@Autowired
	private RepositoryProjection repositoryProjection;
		
	@Override
	public Projection findOne(Long id) {
		Projection projection = repositoryProjection.findOneById(id);
		
		
		Projection newPr = new Projection();
		/*newPr.setId(projection.getId());
		newPr.setName(projection.getName());
		newPr.setActors(projection.getActors());
		newPr.setRuntime(projection.getRuntime());
		newPr.setRepertory(projection.getRepertory());
		*/
		ArrayList<ProjectionDate> listaDate = new ArrayList();
		for(int i=0; i<projection.getProjectionDates().size();i++) {
			
			
			Date date = new Date();
			if(date.before(projection.getProjectionDates().get(i).getDate())) {
				
				
				listaDate.add(projection.getProjectionDates().get(i));
				System.out.println("aaaaaaaaaaaaa " + projection.getProjectionDates().get(i));
				
			}
		}
		newPr.getProjectionDatess().addAll(listaDate);
		for(int i=0; i<projection.getProjectionDates().size();i++) {
			System.out.println("bbbbbbbbbbb " + projection.getProjectionDates().get(i));
		}
		
		return newPr;
	}

	@Override
	public List<Projection> getAll() {
		List<Projection> projections = repositoryProjection.findAll();
		return projections;
	}

	@Override
	public Projection add(Projection projection) {
		
		return repositoryProjection.save(projection);
	}
	
	
	

}
