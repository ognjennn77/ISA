package projekatISA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projekatISA.domein.ThematicProps;
import projekatISA.repository.RepositoryThematicProps;
import projekatISA.serviceInterface.ThematicPropsServiceInterface;

@Service
public class ThematicPropsService implements ThematicPropsServiceInterface{

	@Autowired
	private RepositoryThematicProps repThemProp;
	
	@Override
	public ThematicProps addThematicProps(ThematicProps tp) {
		
		return repThemProp.save(tp);
	
	}

	@Override
	public List<ThematicProps> getAll() {
		
		return repThemProp.findAll();
	}

	
	
}
