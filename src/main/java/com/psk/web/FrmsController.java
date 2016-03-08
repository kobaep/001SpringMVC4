package com.psk.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by apichat on 3/7/2016 AD.
 */
@Controller
public class FrmsController {
    private final Logger logger = LoggerFactory.getLogger(FrmsController.class);

    @RequestMapping(value = "/frms", method = RequestMethod.GET)
    public ModelAndView frmsIndex(ModelAndView model) {

        logger.debug("-= in FRMS INDEX =-");
        model.setViewName("FRMS-index");

        return model;

    }
}
