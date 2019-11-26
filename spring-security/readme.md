AuthenticationManager has the method authenticate()

If you want to configure the authentication MAnager
1. Get hold of the AuthenticationManagerBuilder
2. Set the configuration on it.

** How do I get Authentication Manager Builder (AUTHENTICATION)
-------------------------------------------
1. In Spring there is a class called WebSecurityConfigureAdapter which has a method configure which takes AuthenticationManagerBuilder as arg
	configure(AuthenticationManagerBuilder)
2. Spring Security framework calls that method i.e configure method


How to set a PasswordEncoder
----------------------------
1. Jst expose a @Bean of type PasswordEncoder


| ** API ** | ** Roles allows to access it ** |
| ********* | ******************************* |
|  /        | All(unauthenticated also)       |
| /user     | USER and ADMIN roles            |
| /admin    |    ADMIN role only              |


** AUTHENTICATION **
- override **configure(AuthenticationManagerBuilder)**

** AUTHORIZATION **
- override **configure(HttpSecurity) **






