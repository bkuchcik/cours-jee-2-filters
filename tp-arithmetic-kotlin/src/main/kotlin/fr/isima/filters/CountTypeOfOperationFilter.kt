package fr.isima.filters

import fr.isima.service.OperationCounter
import javax.servlet.*
import javax.servlet.http.HttpServletRequest


/**
 * Compte les requêtes en fonction de leur type (math ou chaine)
 *
 * @author Benjamin Kuchcik
 */
class CountTypeOfOperationFilter(private val operationCounter: OperationCounter) : Filter {

    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpReq = request as HttpServletRequest
        System.out.println(operationCounter.countRequest(httpReq.servletPath))
    }

    override fun destroy() {

    }

    override fun init(arg0: FilterConfig) {}

}
