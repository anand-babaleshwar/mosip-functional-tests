package io.mosip.registration.processor.abis;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.mosip.registration.processor.abis.messagequeue.AbisMessageQueueImpl;

public class RestAbisApplication {
	
	public static void main( String[] args ) throws IOException
    {
		AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
		configApplicationContext.scan("io.mosip.registration.processor.abis.config","io.mosip.registration.processor.stages.config",
				"io.mosip.registration.processor.status.config",
				"io.mosip.registration.processor.packet.storage.config", "io.mosip.registration.processor.core.config",
				"io.mosip.registration.processor.core.kernel.beans"
				);
		configApplicationContext.refresh();
		AbisMessageQueueImpl abisMessageQueueImpl = configApplicationContext.getBean(AbisMessageQueueImpl.class);
		abisMessageQueueImpl.runAbisQueue();
    }  
}

