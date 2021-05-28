# RaspberryPiIntercom
CSE3009 IoT Project - Smart Intercom
18BCE0858, 19BCE2450, 19BEC0557

# Parts Used
1. Push button
2. Raspberry Pi Camera

# Setting Up
##  Motion (For Camera)
1. In terminal, run `sudo apt install autoconf automake build-essential pkgconf libtool git libzip-dev libjpeg-dev gettext libmicrohttpd-dev libavformat-dev libavcodec-dev libavutil-dev libswscale-dev libavdevice-dev default-libmysqlclient-dev libpq-dev libsqlite3-dev libwebp-dev motion`
2. Change `/etc/motion/motion.conf` to appropriate settings.
3. In `/etc/default/motion`, change `start_motion_daemon` to yes.
4. Enable the camera with `sudo raspi-config` (Found in Interfacing) then type `sudo modprobe bcm2835-v4l2`.
5. Type `sudo service motion start` then `sudo motion`
6. Go to a browser and type the url `rasp_ip_addr:port`
7. Voila!

## Android App
Built with Android Studio 4.1.3.
Just open the project folder using Android Studio and run it.

## PushBullet (For Push Notifications)
Get your access token and device name from https://www.pushbullet.com/ and replace them in app.py.

## Flask Server (For API)
1. Run `python3 -m pip install -r requirements.txt` to install all dependencies (Use a virtual environment so that you don't mess up your normal python)
2. Run `flask run --host=0.0.0.0` and that should start up the flask server in your private network.
