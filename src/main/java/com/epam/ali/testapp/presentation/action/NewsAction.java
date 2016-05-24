package com.epam.ali.testapp.presentation.action;

import com.epam.ali.testapp.database.NewsDAO;
import com.epam.ali.testapp.model.News;
import com.epam.ali.testapp.presentation.form.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsAction extends DispatchAction {

    public ActionForward setNewsDao(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        return super.execute(mapping, form, request, response);
    }

    public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDAO newsDAO = new NewsDAO();
        newsForm.setNewsList(newsDAO.getList());
        System.out.println();
        return mapping.findForward("list");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News news = new News();
        news.setTitle(newsForm.getTitle());
        news.setBrief(newsForm.getBrief());
        news.setContent(newsForm.getContent());
        return mapping.findForward("add");
    }

    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        String id = request.getParameter("id");
        NewsDAO newsDAO = new NewsDAO();
        News newsMessage = newsDAO.fetchById(Integer.parseInt(id));
        newsForm.setNewsMessage(newsMessage);
        return mapping.findForward("view");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDAO newsDAO = new NewsDAO();
        String[] deletedList = newsForm.getDeleted();
        if (deletedList != null) {
            for (int i = 0; i < deletedList.length; i++) {
                newsDAO.remove(Integer.parseInt(deletedList[i]));
            }
        } else {
            newsDAO.remove(newsForm.getNewsMessage().getId());
        }
        return mapping.findForward("delete");
    }

    public ActionForward cancel(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("success");
    }

}
