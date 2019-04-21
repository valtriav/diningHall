package com.lovo.cq.shopping10_1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovo.cq.shopping10_1.model.Model;
import com.lovo.cq.shopping10_1.po.Inform;

public class AddInformServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String informTitle = request.getParameter("informTitle");
		String informContent = request.getParameter("informContent");
		System.out.println("informTitle:");
		if(informTitle != null && informContent != null) {
			System.out.println("informTitle:"+informTitle);
			byte[] buf1 = informTitle.getBytes("gb2312");
			byte[] buf2 = informContent.getBytes("gb2312");
			Model model = new Model();
			Inform inform = new Inform();
			inform.setInformTitle(new String(buf1));
			inform.setInformContent(new String(buf2));
			if(model.addInform(inform)) {
				request.setAttribute("message", "添加成功");
			} else {
				request.setAttribute("message", "添加失败");
			}
			request.getRequestDispatcher("Admin/pages/addInform.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
