from flask import Flask
from time import sleep
from pushbullet import Pushbullet
import RPi.GPIO as GPIO

def setAngle(angle):
    GPIO.setmode(GPIO.BOARD)
    GPIO.setup(11, GPIO.OUT)
    pwm=GPIO.PWM(11, 50)
    pwm.start(0)
    duty = angle / 18 + 3
    GPIO.output(11, True)
    pwm.ChangeDutyCycle(duty)
    sleep(1)
    GPIO.output(11, False)
    pwm.ChangeDutyCycle(duty)
    pwm.stop()

def button_callback(channel):
    pb = Pushbullet("Access Token Here")
    dev = pb.get_device('Device Name Here')
    push = dev.push_note("Alert!","Someone is at your door!")
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BOARD)
GPIO.setup(10, GPIO.IN, pull_up_down=GPIO.PUD_DOWN)
GPIO.add_event_detect(10, GPIO.RISING, callback=button_callback)

app = Flask(__name__)

@app.route("/unlock")
def index():
    setAngle(180)
    sleep(5)
    setAngle(0)
    return "Unlocked and locked succesfully!"