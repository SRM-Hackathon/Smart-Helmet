import RPi.GPIO as a
import time
import os
a.setwarnings(False)
a.setmode(a.BOARD)
a.setup(8,a.IN)
count=0
while 1:
    input=a.input(8)
    if input==0:
        os.system('/home/pi/program/pushbullet.sh "Your friend has met with an accident"')             
        print"vibration occured"
          
      

    
 
    
