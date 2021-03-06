package projekatISA.service;

import java.util.ArrayList;
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
		List<ThematicProps> list = repThemProp.findAll(); 
		List<ThematicProps> retlist= new ArrayList<>();
		for(ThematicProps pr : list) {
			if(!(pr.isReserved())) {
				retlist.add(pr);
			}
		}
		return retlist;
	}

	@Override
	public ThematicProps reservingProps(Long id,Long tp) {
		
		User user = repositoryUser.findByIdEquals(id);
		if(!(user==null)) {
			ThematicProps thematicProps = repThemProp.findByIdEquals(tp);
			thematicProps.setReserved(true);
			thematicProps.setUser(user);
			repThemProp.save(thematicProps);
			return thematicProps;
		}
		return null;
	}

	@Override
	public ThematicProps editProps(ThematicProps tp) {
		
		ThematicProps thematicp = repThemProp.findByIdEquals(tp.getId());
		if(!(thematicp==null)) {
			if(!thematicp.isReserved()) {
				thematicp.setDescription(tp.getDescription());
				thematicp.setName(tp.getName());
				thematicp.setPrice(tp.getPrice());
				thematicp.setReserved(tp.isReserved());
				thematicp.setUser(tp.getUser());
				thematicp.setCinemaTheatre(tp.getCinemaTheatre());
				
				repThemProp.save(thematicp);
				return thematicp;
			}
		}
		
		return null;
	}

	@Override
	public ThematicProps findOneProps(Long id) {

		ThematicProps tp =  repThemProp.findByIdEquals(id);
		return tp;
	}

	/**
	 * @param id of the themaic props
	 */
	@Override
	public User findUserOfProps(Long id) {
		
		ThematicProps tp = repThemProp.findByIdEquals(id);
		return tp.getUser();
		
	}

	@Override
	public ThematicProps deleteProps(Long id) {
		ThematicProps tp = repThemProp.findByIdEquals(id);
		if(!(tp==null)) {
			repThemProp.delete(tp);
			return tp;
		}
		return null;
	}

	
	
}
