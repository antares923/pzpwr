package com.pzpwr.core.endpoint;

import com.pzpwr.core.exception.StorageException;
import com.pzpwr.core.storage.UserStorage;
import com.pzpwr.core.type.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GetRights {

    @Autowired
    private UserStorage userStorage;

    @RequestMapping(value = "user/get_rights", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getRights(@RequestParam(required = true) String login) throws StorageException {
        try {
            User user = userStorage.get(login);
            return new ResponseEntity<>(user.getRights().toString(), HttpStatus.OK);
        }catch(StorageException e ) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
