package projekatISA.serviceInterface;

import java.util.List;

import projekatISA.domein.ThematicProps;

public interface ThematicPropsServiceInterface {

	ThematicProps addThematicProps(ThematicProps tp);
	
	List<ThematicProps> getAll();
}
