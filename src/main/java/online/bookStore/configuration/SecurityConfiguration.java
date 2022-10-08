package online.bookStore.configuration;
import lombok.RequiredArgsConstructor;
import online.bookStore.service.impl.UsersDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
//@EnableGlobalAuthentication
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration  {
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    private final UsersDetailServiceImpl userDetailService;
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/user/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailService);
//        provider.setPasswordEncoder(passwordEncoder);
//
//        return provider;
//    }
}
