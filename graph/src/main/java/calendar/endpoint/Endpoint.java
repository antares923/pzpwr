package calendar.endpoint;

import calendar.exception.StorageException;
import calendar.gui.GUI;
import calendar.storage.Storage;
import calendar.type.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Endpoint {

    @Autowired
    private Storage storage;

    @RequestMapping(value = "add_data", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addUser(@RequestBody(required = true) List<Visit> visits) throws StorageException {

        storage.setData(visits);
        ResponseEntity response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
}
