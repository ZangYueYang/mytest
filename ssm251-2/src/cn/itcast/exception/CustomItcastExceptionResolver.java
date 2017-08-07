package cn.itcast.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomItcastExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception ex) {
		String msg = "";
		if (ex instanceof ItcastException) {
			// ҵ��Υ�洦��
			msg = ex.getMessage();
		} else {
			// ϵͳ�쳣����
			msg = "ϵͳ��æ�����Ժ�����";
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg", msg);
		modelAndView.setViewName("items/error");
		return modelAndView;
	}

}
