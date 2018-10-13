package com.uporanges.controller.teacher;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.uporanges.entity.t_company;

public class TeacherController {
   private ClassLoader loader;
private Class<?>[] interfaces;
private InvocationHandler h;
t_company tt = Proxy.newProxyInstance(loader, interfaces, h);
}
