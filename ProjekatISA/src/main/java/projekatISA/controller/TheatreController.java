package projekatISA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projekatISA.domein.Theatre;
import projekatISA.domeinDTO.TheatreInfoDTO;
import projekatISA.service.TheatreService;

@RestController
@RequestMapping(value="/api/theatres")
public class TheatreController {

	@Autowired
	private TheatreService theatreService; 
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Theatre> getTheatre(@PathVariable Long id){
		System.out.println("aaaaa");
		Theatre theatre = theatreService.findOne(id);	
		if(theatre == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(theatre, HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getTheatres", method=RequestMethod.GET)
	public ResponseEntity<List<TheatreInfoDTO>> getTheatres(){
		 List<Theatre> theatres = theatreService.findAll();
		 List<TheatreInfoDTO> listTheatredto = new ArrayList();

		 for(Theatre theatre : theatres) {
			 TheatreInfoDTO theatredto = new TheatreInfoDTO();
			 theatredto.setAddress(theatre.getAddress());
			 theatredto.setDescription(theatre.getDescription());
			 theatredto.setName(theatre.getName());
			 theatredto.setRating(theatre.getRaiting());
			 listTheatredto.add(theatredto);
		 }
		 
		 return new ResponseEntity<>(listTheatredto,HttpStatus.OK); 
	}
	
}
