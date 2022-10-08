package online.bookStore.security;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.bookStore.dto.UserDto;
import online.bookStore.service.impl.UsersDetailServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")){
            String token = header.substring(7);
            if (jwtService.validateToken(token)){
                Integer subject = (Integer)jwtService.getClaim(token, "sub");
                UserDto userDto = UsersDetailServiceImpl.userMap.get(subject);

                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDto, null, userDto.getAuthorities()
                );

                WebAuthenticationDetails authenticationDetails = new WebAuthenticationDetailsSource().buildDetails(request);
                authToken.setDetails(authenticationDetails);

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
    }
}
