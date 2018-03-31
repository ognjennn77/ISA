package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ThematicProps;

public interface ThematicPropsServiceInterface {

	ThematicProps addThematicProps(ThematicProps tp);
	
	List<ThematicProps> getAll();
	
	ThematicProps reservingProps(Long id,ThematicProps tp);
	
	ThematicProps editProps(ThematicProps tp);
	
	ThematicProps findOneProps(Long id);
}
