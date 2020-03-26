package nik.pra.config;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nik.pra.dao.StudentDaoImpl;
import nik.pra.model.Student;

@Controller
public class StController {

	@RequestMapping("/insert")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = (request.getParameter("name"));

		ApplicationContext context = new AnnotationConfigApplicationContext(Mydatabase.class);
		StudentDaoImpl student = context.getBean(StudentDaoImpl.class);

		int k = student.insert(id, name);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("insert.jsp");

		if (k > 0)
			mv.addObject("result", "SUCCESS");
		else
			mv.addObject("result", "FAILURE");

		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = (request.getParameter("name"));

		ApplicationContext context = new AnnotationConfigApplicationContext(Mydatabase.class);
		StudentDaoImpl student = context.getBean(StudentDaoImpl.class);

		int k = student.update(id, name);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("update.jsp");

		if (k > 0)
			mv.addObject("result", "SUCCESS");
		else
			mv.addObject("result", "FAILURE");

		return mv;

	}

	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("id"));

		ApplicationContext context = new AnnotationConfigApplicationContext(Mydatabase.class);
		StudentDaoImpl student = context.getBean(StudentDaoImpl.class);

		int k = student.delete(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("delete.jsp");

		if (k > 0)
			mv.addObject("result", "SUCCESS");
		else
			mv.addObject("result", "FAILURE");

		return mv;

	}
	
	@RequestMapping("/getall")
	public ModelAndView getall(HttpServletRequest request, HttpServletResponse response) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Mydatabase.class);
		StudentDaoImpl student = context.getBean(StudentDaoImpl.class);

		List<Student> students = student.getall();
		

		ModelAndView mv = new ModelAndView();
		mv.setViewName("get.jsp");
		mv.addObject("students", students);

		return mv;

	}

}
