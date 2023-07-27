#!/usr/bin/python3

import rclpy
from rclpy.node import Node 
from geometry_msgs.msg import Twist
class DrawCirleNode(Node):
    def __init__(self):
        super().__init__("draw_circle")
        self._counter=0
        self.cmd_vel_pub = self.create_publisher(Twist,"/turtle1/cmd_vel",10)
        self.create_timer(0.5,self.send_velocity_commd)
    
    def send_velocity_commd(self):
        msg = Twist()
        msg.linear.x=2.0
        msg.angular.z=1.0
        self.cmd_vel_pub.publish(msg)

        

def main(args=None):
    rclpy.init(args=args)
    node = DrawCirleNode()
    rclpy.spin(node)
    rclpy.shutdown()

if __name__== '__main__':
    main()
