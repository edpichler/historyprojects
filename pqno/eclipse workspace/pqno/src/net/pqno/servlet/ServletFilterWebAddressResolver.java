package net.pqno.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.pqno.bigtable.BigTableManager;
import net.pqno.vo.WebAddress;

public class ServletFilterWebAddressResolver implements Filter {
	private Logger logger = Logger
			.getLogger(ServletFilterWebAddressResolver.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String requestURI = ((HttpServletRequest) request).getRequestURI();
		if (!requestURI.contains(".") && !requestURI.endsWith("/pqno/greet")) {

			// TODO LOG DO IP QUE ESTÁ TENTANDO ACESSAR
			requestURI = requestURI.replaceFirst("/", "");
			BigTableManager bg = new BigTableManager();
			final WebAddress webAddressBySuffix = bg
					.getWebAddressBySuffix(requestURI);
			if (webAddressBySuffix != null) {
				String originalUrl = webAddressBySuffix.getOriginalUrl();
				((HttpServletResponse) response).sendRedirect(originalUrl);
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.finest("Initing the ServletFilter "
				+ ServletFilterWebAddressResolver.class.getName());
	}

	@Override
	public void destroy() {
		logger.finest("Destroying the ServletFilter "
				+ ServletFilterWebAddressResolver.class.getName());
	}

}
