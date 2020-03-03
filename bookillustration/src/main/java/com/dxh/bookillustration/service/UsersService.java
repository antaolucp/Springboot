package com.dxh.bookillustration.service;

import com.dxh.bookillustration.mapper.UsersMapper;
import com.dxh.bookillustration.pojo.KUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Component
@Service
public class UsersService {
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    JavaMailSender javaMailSender;
    public List<KUser> findUserall(String page){
        if(page.equals("product"))
            return usersMapper.findUserallcount();
        else if(page.equals("new"))
            return usersMapper.findUserallnew();
        else
            return usersMapper.findUserallfans();
    }
    public List<KUser> findUserallcount(){
        return usersMapper.findUserallcount();
    }

    public KUser findUserbymail(String user_mail){ return usersMapper.findUserBymail(user_mail);}

    @Async("taskExecutor")
    public void updateUserPassword(KUser user){usersMapper.updateUserPassword(user);}

    public void updateUsermail(KUser user){usersMapper.updataUsermail(user);}

    public void InsetUser(KUser user){usersMapper.InsetUser(user);}

    @Async("taskExecutor")
    public void sendEmail(KUser user, Integer rannum) {
        try{
            MimeMessage mimeMessage=javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setSubject("p站");
            mimeMessageHelper.setText("" +
                    "<tbody>" +
                    "   <tr>" +
                    "       <td style=\"font-family:'Microsoft Yahei'\">" +
                    "           <p style=\"font-size:22px;font-family:'Microsoft Yahei'\">" +
                    "               亲爱的 "+user.getUser_name()+"，您好！" +
                    "           </p>" +
                    "           <p style=\"font-size:14px; color:#666666; line-height:36px;font-family:'Microsoft Yahei';\">" +
                    "               以下为你的验证码：<br>" +
                    "               <h1><b>"+rannum+"</b></h1>" +
                    "               <br></p>" +
                    "       </td>" +
                    "   </tr>" +
                    "</tbody>",true);
            mimeMessageHelper.setFrom("p站<a377605526@163.com>");
            mimeMessageHelper.setTo(user.getUser_mail());
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e){
            e.printStackTrace();
        }

    }
}
