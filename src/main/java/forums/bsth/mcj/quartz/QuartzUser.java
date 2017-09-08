package forums.bsth.mcj.quartz;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class QuartzUser {
	Logger logger = LoggerFactory.getLogger(QuartzUser.class);
	public void start(){  
//		logger.info(System.currentTimeMillis()+"\t"+"ssss");
//		System.out.println(System.currentTimeMillis()+"===");
/*        File file = new File("C:\\Users\\Administrator\\Desktop\\你好.html");
        if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			file.delete();
			System.out.println("已经有了"+file.getName()+new Date());
			
		}
		Date date = new Date();
		System.err.println(date);*/
    }  
      
    public void stop(){  
    	/* int[] nums = {2,4,6,3,1,11,22,12,13,34,19,8,5};
       Arrays.sort(nums);
       int sd = 11;
       System.out.println("dhsakjh");
       if (nums != null) {
       while (true) {
    	   int min = 0;
           int max = nums.length-1;
           int low = 0;
           if (min <= max) {
			low = (min+max)/2 ;
			int ss = nums[low];
			if (sd == ss) {
				System.err.println("鎵惧埌浜�"+sd);
				break;
			}else if (sd<ss) {
				low = (min+(low-1))/2 ;
			}else if (sd>ss) {
				low = (low+max)/2 ;
			}
		}
	}
       }  	   
       System.out.println();*/
    }  
}
