package fr.isima.filters

import java.io.IOException
import java.time.Duration
import java.time.LocalTime.now
import javax.servlet.*
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest

/**
 * Ce filter mesure le temps d'execution d'un fr.isima.service, en utilisant la nouvelle
 * API de date de Java inspirée de la librarie joda time.
 *
 * @author Benjamin
 */
@WebFilter("/*")
class MeasureExecutionDurationFilter : Filter {

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(req: ServletRequest, resp: ServletResponse, chain: FilterChain) {
        // utilisation de l'import static import static java.time.LocalTime.now;
        val before = now()
        chain.doFilter(req, resp)
        val after = now()
        val duration = Duration.between(before, after)
        val httpReq = req as HttpServletRequest
        println("Execution of " + httpReq.servletPath + " took " + duration.toMillis() + "ms")
    }

    override fun init(arg0: FilterConfig) {}
    override fun destroy() {}

}
