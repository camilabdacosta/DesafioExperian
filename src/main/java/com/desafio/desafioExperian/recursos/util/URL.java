package com.desafio.desafioExperian.recursos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
		public static String decodeParam (String data) {
			try {
				return URLDecoder.decode(data,"UTF-8");
			} catch (UnsupportedEncodingException e) {
					return "";
			}
		}
}
