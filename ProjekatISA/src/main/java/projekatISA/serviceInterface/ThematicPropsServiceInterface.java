package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ThematicProps;
import projekatISA.domein.User;

public interface ThematicPropsServiceInterface {

	ThematicProps addThematicProps(ThematicProps tp);
	
	List<ThematicProps> getAll();
	
	ThematicProps reservingProps(Long id,ThematicProps tp);
	
	ThematicProps editProps(ThematicProps tp);
	
	ThematicProps findOneProps(Long id);
	
	User findUserOfProps(Long id);
	
	ThematicProps deleteProps(Long id);
}
