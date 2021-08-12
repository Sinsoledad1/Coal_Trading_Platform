package com.tom.service.Impl;

import com.tom.dao.AdminDAO;
import com.tom.dao.UserDao;
import com.tom.entity.dto.AdminDTO;
import com.tom.entity.dto.LoginDTO;
import com.tom.entity.dto.RegisterDTO;
import com.tom.entity.pojo.Admin;
import com.tom.entity.pojo.User;
import com.tom.entity.vo.LoginVO;
import com.tom.exception.BasicException;
import com.tom.service.UserService;
import com.tom.utils.DateTimeTransferUtil;
import com.tom.utils.IdWorker;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author BeiChen
 * @Date 2021/8/11 11:50
 * @Version 1.0
 */
@Component
@Transactional(rollbackForClassName = "Exception.class")
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final AdminDAO adminDAO;
    private final IdWorker idWorker;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final Pattern p = Pattern.compile("^1(3|5|7|8|4|9)\\d{9}");
    public UserServiceImpl(UserDao userDao, AdminDAO adminDAO, IdWorker idWorker, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDao = userDao;
        this.adminDAO = adminDAO;
        this.idWorker = idWorker;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     * 用户注册
     * @param registerDTO
     * @param session
     * @return
     */
    @Override
    public Integer Register(RegisterDTO registerDTO, HttpSession session) {
        //        if (!UserDTO.getVerifyCode().toUpperCase().equals(session.getAttribute("verifyCode"))) {
//            throw new BasicException("验证码错误");
//        }
        session.removeAttribute("verifyCode");

        if(!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())){
            throw new BasicException("确认密码和密码不相同");
        }
        Matcher m = p.matcher(registerDTO.getUsername());
        if (!m.matches()){
            throw new BasicException("请输入正确的手机号");
        }
        if(registerDTO.getPassword().length() < 6){
            throw new BasicException("密码长度不能小于6");
        }
        //判断密码是否为纯数字
        if(registerDTO.getPassword().matches("[0-9]+")){
            throw new BasicException("密码不能为纯数字");
        }

        User user=new User();
        BeanUtils.copyProperties(registerDTO,user);
        //设置id
        user.setUid(idWorker.nextId()+"");
        //设置添加时间
        user.setAddTime(DateTimeTransferUtil.getNowTimeStamp());
        //加密密码
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //设置用户角色
        user.setRole(0);
        try {
            return userDao.insert(user);
        } catch (Exception e) {
            throw new BasicException("该号码已被注册！");
        }
    }

    /**
     * 用户登录
     * @param loginDTO
     * @param session
     * @return
     */
    @Override
    public LoginVO Login(LoginDTO loginDTO, HttpSession session) {
        //        if (!ulDTO.getVerifyCode().toUpperCase().equals(session.getAttribute("verifyCode"))) {
//            throw new BasicException("验证码错误！");
//        }
        session.removeAttribute("verifyCode");
//        //调用方法，根据获得的username获取数据库中的user信息

        User trueUser = userDao.UserLogin(loginDTO.getUsername());
        System.out.println(trueUser.toString());

        if (trueUser == null){
            //trueUser为空说明无此用户名的用户
            throw new BasicException("无此用户！");
        }
        //匹配密码
        if (bCryptPasswordEncoder.matches(loginDTO.getPassword(), trueUser.getPassword())) {

            //存入session
            session.setAttribute("User", trueUser);
            LoginVO userShowVO = new LoginVO();
            //返回用户详细信息（除了密码）

            BeanUtils.copyProperties(trueUser, userShowVO);

            return userShowVO;
        }
        throw new BasicException("用户名或密码有误！");
    }

    /**
     * 普通用户提交管理员申请
     * @param adminDTO
     * @param session
     * @return
     */
    @Override
    public Integer Apply(AdminDTO adminDTO, HttpSession session) {
        User user= (User) session.getAttribute("User");
        
        Admin admin=new Admin();
        BeanUtils.copyProperties(adminDTO, admin);

        //设置管理员id
        admin.setAid(idWorker.nextId()+"");
        //设置用户id
        admin.setUid(user.getUid());
        //设置角色
        admin.setRole(0);
        //设置审核状态
        admin.setStatus(0);
        //设置添加时间
        admin.setAddTime(DateTimeTransferUtil.getNowTimeStamp());

        return adminDAO.insert(admin);
    }
}
