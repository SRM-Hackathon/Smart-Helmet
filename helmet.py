import re
import time
import json
import psutil
from slackclient import SlackClient
import RPi.GPIO as a
import time
from picamera import PiCamera
import os
from time import sleep
a.setwarnings(False)

a.setmode(a.BOARD)
a.setup(8,a.IN)
a.setup(7,a.OUT)
a.setup(13,a.OUT)


slack_client = SlackClient("xoxb-188960937920-eAEE7oDvaZYiAGudtMZsblWb")



user_list = slack_client.api_call("users.list")
for user in user_list.get('members'):
    if user.get('name') == "mybot":
        slack_user_id = user.get('id')
        break



if slack_client.rtm_connect():
    print "Connected!"

    while True:
        for message in slack_client.rtm_read():
            if 'text' in message and message['text'].startswith("<@%s>" % slack_user_id):

                print "Message received: %s" % json.dumps(message, indent=2)

                message_text = message['text'].\
                    split("<@%s>" % slack_user_id)[1].\
                    strip()

                if re.match(r'.*(cpu).*', message_text, re.IGNORECASE):
                    cpu_pct = psutil.cpu_percent(interval=1, percpu=False)

                    slack_client.api_call(
                        "chat.postMessage",
                        channel=message['channel'],
                        text="My CPU is at %s%%." % cpu_pct,
                        as_user=True)

                if re.match(r'.*(memory|ram).*', message_text, re.IGNORECASE):
                    mem = psutil.virtual_memory()
                    mem_pct = mem.percent

                    slack_client.api_call(
                        "chat.postMessage",
                        channel=message['channel'],
                        text="My RAM is at %s%%." % mem_pct,
                        as_user=True)
                if re.match(r'.*(hi|hello).*', message_text, re.IGNORECASE):
                    

                    slack_client.api_call(
                        "chat.postMessage",
                        channel=message['channel'],
                        text="Welcome to mybot",
                        as_user=True)
               
               

                if re.match(r'.*(lighton).*', message_text, re.IGNORECASE):
                   a.output(13,1)
                   slack_client.api_call(
                        "chat.postMessage",
                        channel=message['channel'],
                        text="lightison",
                        as_user=True)

                if re.match(r'.*(lightoff).*', message_text, re.IGNORECASE):
                   a.output(13,0)

                if re.match(r'.*(blink).*', message_text, re.IGNORECASE):
                   while 1:
                        for x in[13]:
                            a.output(x,1)
                            time.sleep(4)
                            a.output(x,0)   
                            time.sleep(4)
            
                if re.match(r'.*(Helmeton).*', message_text, re.IGNORECASE):
                         slack_client.api_call(
                            "chat.postMessage",
                             channel=message['channel'],
                             text="Device has been Turned On",
                             as_user=True)
    
                         count=0
                         while 1:
                            input=a.input(8)
                            if count<2 and input==1:
                                count+=1
                            if count==2 and input==1:
                                time.sleep(5)

                                os.system('/home/pi/program/pushbullet.sh "Your friend has met with an accident.The location is : https://www.google.co.in/maps/@12.824836,80.046946"')             
                                time.sleep(50)

                  
                if re.match(r'.*(video).*', message_text, re.IGNORECASE):
                    camera=PiCamera()
                    camera.start_preview()
                    camera.start_recording('/media/pi/2015-6DEA/ne.h264')
                    sleep(10)
                    camera.stop_recording()
                    camera.stop_preview()

                    
                     

                    
           
                              
                     
                    
                    
