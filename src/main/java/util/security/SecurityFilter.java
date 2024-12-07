package util.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import usuario.UsuarioRepository;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private PW3TokenService pw3TokenService;

@Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        var authorizationHeader = request.getHeader("Authorization");


        if (authorizationHeader != null) {

            authorizationHeader = authorizationHeader.replace("Bearer ", "");

            var subject = pw3TokenService.getSubject(authorizationHeader);

            var usuario = repository.finbyLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null,
                    usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }
}