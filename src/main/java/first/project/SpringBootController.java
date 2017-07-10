package first.project;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import first.model.RepositoryService;

@RestController
public class SpringBootController {
	
	@RequestMapping(path="/api/{name}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, String>> welcome(@PathVariable("name") String name) {
		RepositoryService rs = new RepositoryService();
		Map<String, String> model = rs.getValue(name);
		return ResponseEntity.ok(model);
	}
}
