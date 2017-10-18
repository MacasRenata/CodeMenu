package com.menu.code.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.hibernate.Session;
import com.menu.code.webservice.persistencia.HibernateUtil;

@WebFilter(filterName = "FiltroTransacoesHibernate", urlPatterns = {"*.xhtml"})
public class FiltroTransacoesHibernate implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
        System.out.println("filtros.FiltroTransacoesHibernate.doFilter()");
        try {
            chain.doFilter(request, response);
            sessao.getTransaction().commit();
        } catch(IOException | ServletException e) {
            sessao.getTransaction().rollback();
        }
    }

    @Override
    public void destroy() {
    }
    
}
