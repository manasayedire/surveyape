//package com.sjsu.cmpe275.surveyape;
//
//import com.sjsu.cmpe275.surveyape.service.EmailService;
//import com.sjsu.cmpe275.surveyape.service.QRCodeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import javax.transaction.Transactional;
//import java.util.Arrays;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SurveyapeApplication.class)
//@AutoConfigureMockMvc
//@Transactional
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private QRCodeService qrCodeService;
//
//    @Autowired
//    private EmailService emailService;
//
//    @Value("${hostname}")
//    private String hostname;
//
//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @Test
//    @DirtiesContext
//    public void registerUserTest() throws Exception {
//        this.mockMvc.perform(post("/register?username=Ara&password=podangadai&email=havok.aravind@gmail.com&age=26")).andDo(print()).andExpect(status().isOk());
//    }
//
//    @Test
//    public void loginUserTest() throws Exception{
//        this.mockMvc.perform(get("/login?email=havok.aravind@gmail.com&password=podandgadai")).andDo(print()).andExpect(status().isOk());
//    }
//
//
//    @Test
//    public void qrCodeGen() throws Exception{
//        qrCodeService.generateQRCodeImage("what",100,100,"/ubuntu@ip-172-31-21-42/surveyape/src/main/resources/QRCodes/image2.png");
//    }
//
//
//
//
//    @Test
//    public void sendUniqueInvitationForGeneralSurveyUsersTest() throws Exception{
//        String [] emails = {"aravindhansai@gmail.com","havok.aravind@gmail.com"};
//
//        emailService.sendUniqueInvitationForGeneralSurveyUsers(Arrays.asList(emails),"4");
//
//    }
//
//
//    @Test
//    public void genereateQrCodeTest() throws Exception{
//        emailService.create_QR("http://www.google.com");
//    }
//
//
//    @Test
//    public void sendUniqueInvitationForClosedSurveyUsersTest() throws Exception{
//        String [] emails = {"aravindhansai@gmail.com","havok.aravind@gmail.com"};
//        emailService.sendUniqueInvitationForClosedSurveyUsers(Arrays.asList(emails),"4");
//    }
//
//    @Test
//    public void propertiesFileTest(){
//        logger.info("{} props from file",hostname);
//    }
//
//
//}
//
