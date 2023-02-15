from cscore import CameraServer
import cv2
import numpy as np

CmServer = CameraServer()

CmServer.enableLogging()

camera = CmServer.startAutomaticCapture()
camera.setResolution(1280,720)

sink = CmServer.getVideo()

while True:
   time, input_img = sink.grabFrame()

   if time == 0: # There is an error
      continue
   CmServer.putVideo(input_img)