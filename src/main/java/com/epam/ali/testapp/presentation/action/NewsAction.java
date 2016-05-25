package com.epam.ali.testapp.presentation.action;

import com.epam.ali.testapp.database.NewsDAO;
import com.epam.ali.testapp.model.News;
import com.epam.ali.testapp.presentation.form.NewsForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewsAction extends DispatchAction {

    public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDAO newsDAO = new NewsDAO();
        newsForm.setNewsList(newsDAO.getList());
        return mapping.findForward("list");
    }

    @Override
    protected ActionForward cancelled(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("list");
    }

    public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        News newsMessage = new News();
        NewsDAO newsDAO = new NewsDAO();
        newsMessage.setTitle(newsForm.getTitle());
        newsMessage.setBrief(newsForm.getBrief());
        newsMessage.setContent(newsForm.getContent());
        newsDAO.save(newsMessage);
        return mapping.findForward("add");
    }

    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDAO newsDAO = new NewsDAO();
        News newsMessage = newsDAO.fetchById(Integer.valueOf(newsForm.getId()));
        newsForm.setNewsMessage(newsMessage);
        return mapping.findForward("view");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDAO newsDAO = new NewsDAO();
        newsForm.setNewsMessage(newsDAO.fetchById(Integer.valueOf(newsForm.getId())));
        return mapping.findForward("edit");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDAO newsDAO = new NewsDAO();
        String[] deletedList = newsForm.getDeleted();
        if (deletedList != null) {
            for (int i = 0; i < deletedList.length; i++) {
                newsDAO.remove(Integer.parseInt(deletedList[i]));
            }
            newsForm.setDeleted(null);
        } else {
            newsDAO.remove(newsForm.getNewsMessage().getId());
        }
        return mapping.findForward("delete");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        NewsForm newsForm = (NewsForm) form;
        NewsDAO newsDAO = new NewsDAO();
        News newsMessage = newsForm.getNewsMessage();
        newsMessage.setTitle(newsForm.getTitle());
        newsMessage.setDate(DateTime.parse(newsForm.getDate(), DateTimeFormat.forPattern("dd/MM/YYYY")));
        newsMessage.setBrief(newsForm.getBrief());
        newsMessage.setContent(newsForm.getContent());
        newsDAO.update(newsMessage);
        return mapping.findForward("save");
    }

}
