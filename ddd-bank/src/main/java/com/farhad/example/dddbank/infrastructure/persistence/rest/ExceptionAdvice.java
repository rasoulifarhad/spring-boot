package com.farhad.example.dddbank.infrastructure.persistence.rest;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletResponse;

import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.farhad.example.dddbank.domain.shared.exceptions.BusinessException;
import com.farhad.example.dddbank.domain.shared.exceptions.ClientCreateWithIdException;
import com.farhad.example.dddbank.domain.shared.exceptions.ClientNotFoundException;
import com.farhad.example.dddbank.domain.shared.exceptions.NotManagedAccountException;
import com.farhad.example.dddbank.domain.shared.exceptions.NotOwnerException;
import com.farhad.example.dddbank.domain.shared.exceptions.WithoutRightException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionAdvice {
    
	public static final String BASE_NAME = "MessageText";


	@ResponseBody
	@ExceptionHandler({ Exception.class })
	/**
	 * Reports the given Exception with messages in three ways:
	 * <ol>
	 * <li>with messages in default language and with stack trace to the error
	 * log</li>
	 * <li>with localized messages according to the given Locale of the web request
	 * to the REST client</li>
	 * <li>as HTTP status code to the REST client</li>
	 * </ol>
	 */
	Problem reportException(final Exception ex, final Locale requestLocale, final HttpServletResponse response) {
		// prepare messages for REST client with the Locale of the request:
		/** Message texts for exceptions. */
		final ResourceBundle requestResourceBundle = ResourceBundle.getBundle(BASE_NAME, requestLocale);
		final StringBuffer clientMessages = new StringBuffer();
		multex.Msg.printMessages(clientMessages, ex, requestResourceBundle);
		final String clientMesagesString = clientMessages.toString();

		// prepare log report with messages and stack trace:
		final StringBuffer serverMessages = new StringBuffer();
		serverMessages.append("Processing REST request threw exception:\n");
		final Locale defaultLocale = Locale.getDefault();
		final ResourceBundle defaultResourceBundle = ResourceBundle.getBundle(BASE_NAME, defaultLocale);
		if (!defaultResourceBundle.equals(requestResourceBundle)) {
			serverMessages.append(clientMesagesString);
			serverMessages.append("\n-----\n");
		}
		multex.Msg.printReport(serverMessages, ex, defaultResourceBundle);

		// log the report on the server:
		log.error(serverMessages.toString());
		// respond with localized messages to the client:
		response.setStatus(exceptionToStatus(ex).value());
        return Problem.create()
			.withStatus(exceptionToStatus(ex))
			.withTitle("error")
			.withDetail(clientMesagesString);
	}

	final String restInterfacePackagePrefix = _computePackagePrefix(ClientCreateWithIdException.class);
	final String domainPackagePrefix = _computePackagePrefix(NotOwnerException.class);

	/**
	 * Converts the given exception to the best suiting HTTP response status.
	 * 
	 * @return one of HttpStatus.NOT_FOUND, HttpStatus.FORBIDDEN,
	 *         HttpStatus.BAD_REQUEST, HttpStatus.INTERNAL_SERVER_ERROR
	 * @param exc
	 *            the exception to be converted
	 */
	HttpStatus exceptionToStatus(final Exception exc) {
		if (exc instanceof ClientNotFoundException) {
			return HttpStatus.NOT_FOUND;
		}
		if (exc instanceof NotManagedAccountException) {
			return HttpStatus.NOT_FOUND;
		}
		if (exc instanceof NotOwnerException) {
			return HttpStatus.FORBIDDEN;
		}
		if (exc instanceof WithoutRightException) {
			return HttpStatus.FORBIDDEN;
		}
		if (isRuleViolation(exc)) {
			return HttpStatus.BAD_REQUEST;
		}
		return HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	private boolean isRuleViolation(final Exception exception) {
		final String excClassName = exception.getClass().getName();
		if(exception instanceof BusinessException) {
			return false;
		}
		if (excClassName.startsWith(restInterfacePackagePrefix) || excClassName.startsWith(domainPackagePrefix)) {
			return true;
		}
		//comes from infrastructure layer or lower
		return false;
	}

	/**
	 * Returns the name prefix of all classes in the package of the given exception
	 * class.
	 * 
	 * @return if the given class is modeled in the package
	 *         <code>tld.mysoftware.domain</code>, the result will be
	 *         <code>tld.mysoftware.domain.</code> with trailing dot.
	 * @param excClass
	 *            a Class object for a class in a package
	 */
	String _computePackagePrefix(final Class<?> excClass) {
		final String packageName = excClass.getPackage().getName();
		return packageName + '.';
	}

}
