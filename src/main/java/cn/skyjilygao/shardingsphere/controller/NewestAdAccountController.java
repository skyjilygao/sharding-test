package cn.skyjilygao.shardingsphere.controller;

import cn.skyjilygao.shardingsphere.entity.NewestAdAccount;
import cn.skyjilygao.shardingsphere.service.NewestAdAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@Controller
@RestController
@RequestMapping("/adaccount")
public class NewestAdAccountController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewestAdAccountService newestAdAccountService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<Integer> deleteByPrimaryKey(@PathVariable("id") Long id) {
        boolean delete = this.newestAdAccountService.delete(id);
        return new ResponseEntity<Integer>(1,HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<Integer> insert(@RequestBody  NewestAdAccount record) {
        this.newestAdAccountService.addOrUpdate(record);
        return new ResponseEntity<Integer>(1,HttpStatus.OK);
    }

    @RequestMapping(value = "/selective", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<NewestAdAccount>> insertSelective(@RequestBody NewestAdAccount record) {
        return new ResponseEntity<List<NewestAdAccount>>(this.newestAdAccountService.list(record),HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<Integer> updateByPrimaryKey(@RequestBody NewestAdAccount record) {
        this.newestAdAccountService.addOrUpdate(record);
        return new ResponseEntity<Integer>(1,HttpStatus.OK);
    }

    @RequestMapping(value = "/selective/{id}", method = RequestMethod.PUT, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<NewestAdAccount>> updateByPrimaryKeySelective(NewestAdAccount record) {
        return new ResponseEntity<List<NewestAdAccount>>(this.newestAdAccountService.list(record),HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<NewestAdAccount> selectByPrimaryKey(@PathVariable("id") Long id) {
        NewestAdAccount newestAdAccount = this.newestAdAccountService.get(id);
        return new ResponseEntity<NewestAdAccount>(newestAdAccount,HttpStatus.OK);
    }

    @RequestMapping(value = "/date", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public ResponseEntity<List<NewestAdAccount>> byDatee(String d1, String d2) throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = dateformat.parse(d1);
        Date dd2 = dateformat.parse(d2);
        return new ResponseEntity<List<NewestAdAccount>>(this.newestAdAccountService.selectByGmtModified(dd1, dd2),HttpStatus.OK);
    }
}