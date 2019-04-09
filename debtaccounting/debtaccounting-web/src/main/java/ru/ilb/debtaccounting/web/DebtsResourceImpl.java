/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.ilb.debtaccounting.web;

import io.swagger.annotations.Api;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.apache.cxf.jaxrs.ext.search.SearchContext;
import org.apache.cxf.jaxrs.ext.xml.XSLTTransform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ilb.debtaccounting.api.DebtsResource;
import ru.ilb.debtaccounting.logic.DebtLogic;
import ru.ilb.debtaccounting.mappers.DebtMapper;
import ru.ilb.debtaccounting.utils.JaxbHelper;
import ru.ilb.debtaccounting.repositories.DebtRepository;
import ru.ilb.debtaccounting.providers.AuthorizationHandler;
import ru.ilb.debtaccounting.view.Debt;
import ru.ilb.debtaccounting.view.Debts;

@Path("debts")
@Api("debts")
public class DebtsResourceImpl implements DebtsResource {

    @Autowired
    AuthorizationHandler authorizationHandler;

    @Autowired
    JaxbHelper jaxbHelper;

    @Autowired
    private DebtMapper debtMapper;
    
    @Autowired 
    private DebtLogic debtLogic;

    private UriInfo uriInfo;

    @Context
    public void setUriInfo(UriInfo uriInfo) {
        this.uriInfo = uriInfo;
    }

    @Autowired
    DebtRepository debtRepository;

    private SearchContext searchContext;

    @Context
    public void setSearchContext(SearchContext searchContext) {
        this.searchContext = searchContext;
    }

    private static final Logger LOG = LoggerFactory.getLogger(DebtsResourceImpl.class);

    @Override
    public Debts list(Integer limit, String order) {
        return debtMapper.createWrapperFromEntities(debtRepository.findAll());
    }

    @Override
    public long create(Debt debt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(long debtId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    //@Cacheable("find")
    @XSLTTransform(value = "stylesheets/debtaccounting/debt.xsl", mediaTypes = "application/xhtml+xml", type = XSLTTransform.TransformType.SERVER)
//    @Lockable
    public Debt find(long debtId) {
        return debtMapper.createFromEntity(debtLogic.getDebt(debtId));
    }

    @Override
    public void edit(long debtId, Debt debt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
