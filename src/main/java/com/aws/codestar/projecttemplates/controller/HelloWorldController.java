package com.aws.codestar.projecttemplates.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aws.codestar.projecttemplates.model.OtpInputVO;
import com.aws.codestar.projecttemplates.model.OtpResponseVo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Basic Spring MVC controller that handles all GET requests.
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

	@Autowired
	OtpResponseVo otpResp;
	
    private final String siteName;

    public HelloWorldController(final String siteName) {
        this.siteName = siteName;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("siteName", this.siteName);
        return mav;
    }

    @PostMapping(path="/getsms")
	public OtpResponseVo getsms(@RequestBody String inputData) 
	{
		System.out.println("getsms api controller with : "+inputData);
		otpResp.setStatus(true);
		otpResp.setMessage("SUCCESS");
		return otpResp;
	}
	@PostMapping(path="/submitlogin")
	public OtpResponseVo otpValidation(@RequestBody String inputData) throws Exception 
	{
		System.out.println("getsms api controller with : "+inputData);
		ObjectMapper objMapper = new ObjectMapper();
		OtpInputVO otpInput = objMapper.readValue(inputData, OtpInputVO.class);
		String otpNumner = otpInput.getOtpNumber();
		System.out.println("otpNumber : "+otpNumner);
		if(otpNumner.equals("123456")) 
		{
			otpResp.setStatus(true);
			otpResp.setMessage("SUCCESS");
			return otpResp;
		}
		else 
		{
			otpResp.setStatus(false);
			otpResp.setMessage("FAILED");
			return otpResp;
		}
	}
}
