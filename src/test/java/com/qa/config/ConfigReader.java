package com.qa.config;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
 private static final Properties P = new Properties();
 static {
  try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
   if (in == null) throw new IllegalStateException("config.properties not found");
   P.load(in);
  } catch (Exception e) { throw new RuntimeException("Unable to load config.properties", e); }
 }
 private ConfigReader() {}
 public static String get(String key) {
  String env = System.getenv(key.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase());
  String value = System.getProperty(key, env != null ? env : P.getProperty(key));
  if (value == null) throw new IllegalArgumentException("Missing configuration: " + key);
  return value.trim();
 }
 public static int getInt(String key) { return Integer.parseInt(get(key)); }
 public static boolean getBoolean(String key) { return Boolean.parseBoolean(get(key)); }
}
