package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;
import projekatISA.repository.RepositoryThematicProps;
import projekatISA.repository.RepositoryUser;
import projekatISA.serviceInterface.ThematicPropsServiceInterface;

@Service
public class ThematicPropsService implements ThematicPropsServiceInterface{

	@Autowired
	private RepositoryThematicProps repThemProp;
	
	@Autowired
	private RepositoryUser repositoryUser;
	
	@Override
	public ThematicProps addThematicProps(ThematicProps tp) {
		
		return repThemProp.save(tp);
	
	}

	@Override
	public List<ThematicProps> getAll() {
		
		return repThemProp.findAll();
	}

	@Override
	public ThematicProps reservingProps(Long id,ThematicProps tp) {
		
		User user = repositoryUser.findByIdEquals(id);
		if(!(user==null)) {
			ThematicProps thematicProps = repThemProp.findByIdEquals(tp.getId());
			thematicProps.setReserved(true);
			thematicProps.setUser(user);
			repThemProp.save(thematicProps);
			return thematicProps;
		}
		return null;
	}

	
	
}
