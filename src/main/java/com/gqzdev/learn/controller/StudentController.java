package com.gqzdev.learn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.gqzdev.learn.model.Student;
import com.gqzdev.learn.service.CollegeService;
import com.gqzdev.learn.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

/**
 * 
* @ClassName: StudentController
* @Description: TODO(这里用一句话描述这个类的作用)
* @author ganquanzhong
* @date 2019年2月26日 下午11:59:32
 */
@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private CollegeService collegeService;

	@RequestMapping("/studentIndex")
	public ModelAndView studentIndex() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("studentIndex");
		return mav;
	}

	//检查注册名
	@ResponseBody
	@RequestMapping("/checkName")
	public Map<String,String> checkName(String account) {
		Map<String , String > map =new HashMap<>();
		Boolean flag = studentService.checkName(account);
		if (flag){
			map.put("result","success");
		}else {
			map.put("result","error");
		}
		return map;
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("colleges", collegeService.searchCollege());
		mav.setViewName("register");
		return mav;
	}

	//注册添加
	@RequestMapping("/addStudent")
	public ModelAndView addStudent(Student student) {
		studentService.saveStudent(student);
		return new ModelAndView("redirect:/logon.html");
	}

	// 准备添加学生页面
	@RequestMapping("/createStudent")
	public ModelAndView createStudent() {
		ModelAndView mav = new ModelAndView();
		// 学生属于那个学院的
		mav.addObject("colleges", collegeService.searchCollege());
		mav.setViewName("createStudent");
		return mav;
	}

	// 添加学生
	@RequestMapping("/saveStudent")
	public ModelAndView saveStudent(Student student) {
		studentService.saveStudent(student);

		return new ModelAndView("redirect:/searchStudent.html");
	}

	// 查询学生信息
	@RequestMapping("/searchStudent")
	public ModelAndView searchStudent() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("students", studentService.searchStudent());
		mav.setViewName("searchStudent");
		return mav;
	}

	@RequestMapping("/deleteStudent/{id}")
	public ModelAndView deleteStudent(@PathVariable("id") Integer id) {
		studentService.deleteStudent(id);
		return new ModelAndView("redirect:/searchStudent.html");
	}
	
	@RequestMapping("/updateStudent/{id}")
	public ModelAndView updateStudent(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("colleges", collegeService.searchCollege());
		mav.addObject("student", studentService.getStudentById(id));
		mav.setViewName("updateStudent");
		return mav;
	}
	
	@RequestMapping("/updateStudentInfo")
	public ModelAndView updateStudentInfo(HttpSession session) {
		Student student = (Student)session.getAttribute("user");
		ModelAndView mav = new ModelAndView();
		mav.addObject("colleges", collegeService.searchCollege());
		mav.addObject("student", studentService.getStudentById(student.getId()));
		mav.setViewName("updateStudentInfo");
		return mav;
	}
	
	@RequestMapping("/editStudent/{id}")
	public ModelAndView editStudent(@PathVariable("id") Integer id, Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return new ModelAndView("redirect:/searchStudent.html");
	}
	
	//更新个人信息
	@RequestMapping("/editStudentInfo/{id}")
	public ModelAndView editStudentInfo(@PathVariable("id") Integer id, Student student) {
		student.setId(id);
		studentService.updateStudent(student);
		return new ModelAndView("redirect:/searchNotice.html");
	}
	
	//批量添加学生
	@RequestMapping("/createManyStudent")
	public ModelAndView createManyTeacher() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("createManyStudent");
		return mav;
	}

	@RequestMapping("/studentDataImport")
	public ModelAndView teacherDataImport(@RequestParam("file") MultipartFile file) {
		Student student=new Student();
		int totalRows;
		int totalCells;
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		// IO流读取文件
		InputStream input = null;
		HSSFWorkbook wb = null;
		ArrayList<String> rowList = null;
		try {
			input = file.getInputStream();
			// 创建文档
			wb = new HSSFWorkbook(input);
			// 读取sheet(页)
			for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
				HSSFSheet hssfSheet = wb.getSheetAt(numSheet);
				if (hssfSheet == null) {
					continue;
				}
				totalRows = hssfSheet.getLastRowNum();
				// 读取Row,从第二行开始
				for (int rowNum = 1; rowNum <= totalRows; rowNum++) {
					HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					if (hssfRow != null) {
						rowList = new ArrayList<String>();
						totalCells = hssfRow.getLastCellNum();
						// 读取列，从第一列开始
						//Name
						HSSFCell cell = hssfRow.getCell(0);
						student.setName(cell.getStringCellValue());
						//gender
						cell = hssfRow.getCell(1);
						student.setGender((int) cell.getNumericCellValue());
						//college_id
						cell = hssfRow.getCell(2);
						student.setCollegeId((int) cell.getNumericCellValue());
						//telphone
						cell = hssfRow.getCell(3);
						DecimalFormat format = new DecimalFormat("#");
						Number value = cell.getNumericCellValue();
						student.setTelphone(format.format(value));
						//idcard
						cell = hssfRow.getCell(4);
						student.setIdCardNo(cell.getStringCellValue());
						//account
						cell = hssfRow.getCell(5);
						if(cell!=null){
							cell.setCellType(Cell.CELL_TYPE_STRING);
							student.setAccount(cell.getStringCellValue());
						}						
						//password
						cell = hssfRow.getCell(6);
						if(cell!=null){
							cell.setCellType(Cell.CELL_TYPE_STRING);
							student.setPassword(cell.getStringCellValue());
						}	
						//num
						cell = hssfRow.getCell(7);
						if(cell!=null){
							cell.setCellType(Cell.CELL_TYPE_STRING);
							student.setNum(cell.getStringCellValue());
							/*value = cell.getNumericCellValue();
							student.setNum(format.format(value));*/
						}	
						//state
						cell = hssfRow.getCell(8);
						student.setState(cell.getStringCellValue());
						//isDel
						cell = hssfRow.getCell(9);
						student.setIsdel((int) cell.getNumericCellValue());
						studentService.addStudent(student);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/searchStudent.html");
	}
	
	
	/**
	 * 
	 * @Title: searchStudentData
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author ganquanzhong
	 * @date 2019年3月3日 下午11:23:27
	 * @return
	 */
	@RequestMapping("/studentList")
	@ResponseBody
	public List<Student> studentList() {
		List<Student> list=studentService.searchStudent();
		return list;
	}

	
	@RequestMapping("/studentListByPage")
	@ResponseBody()
	public PageInfo<Student> studentListByPage(int page, int pageSize) {
		return studentService.searchStudentByPage(page,pageSize);
	}
	
	
	@RequestMapping("/studentListByTerm")
	@ResponseBody()
	public PageInfo<Student> studentListByTerm(int page, int pageSize,String content,int collegeId) {
		return studentService.searchStudentByTerm(page,pageSize,content,collegeId);
	}

}
