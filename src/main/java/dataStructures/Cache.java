package dataStructures;

import java.util.HashMap;
import java.util.Map;

public class Cache {

 public static void main(String[] args) {
  Cache cache = new Cache(5);
  cache.put(1, 1);
  cache.put(2, 2);
  cache.put(3, 3);
  cache.put(4, 4);
  cache.put(5, 5);
  cache.put(4, 4);
  cache.print();
  cache.put(2, 3);
  cache.print();
  cache.put(6, 6);
  cache.print();
  cache.put(7, 7);
  cache.print();
  cache.put(8, 8);
  cache.print();
 }

 static class AgeCache {

  private Map<Integer, Long> keyAge = new HashMap<>();
  private Map<Long, Integer> ageKey = new HashMap<>();

  private long getMaxAge() {
   return ageKey.keySet().stream().mapToLong(Long::longValue).max().orElse(0);
  }

  private long getMinAge() {
   return ageKey.keySet().stream().mapToLong(Long::longValue).min().orElseThrow();
  }

  public Integer remove() {
   long minAge = getMinAge();
   Integer oldKey = ageKey.remove(minAge);
   keyAge.remove(oldKey);
   return oldKey;
  }

  public void update(Integer key, boolean exists) {
   if (exists) {
    Long previousAge = keyAge.remove(key);
    ageKey.remove(previousAge);
   }
   long maxAge = getMaxAge() + 1;
   keyAge.put(key, maxAge);
   ageKey.put(maxAge, key);
  }
 }

 private Map<Integer, Integer> keyValue;
 private AgeCache ageCache = new AgeCache();
 private int capacity;

 public Cache(int capacity) {
  this.capacity = capacity;
  keyValue = new HashMap<>(capacity);
 }

 public Integer get(Integer key) {
  if (!keyValue.containsKey(key)) {
   return -1;
  }
  ageCache.update(key, false);
  return keyValue.get(key);
 }

 public void put(Integer key, Integer value) {
  Integer mapValue = keyValue.get(key);
  if (mapValue != null) {
   ageCache.update(key, true);
   keyValue.put(key, value);
   return;
  }

  if (keyValue.size() >= capacity) {
   Integer old = ageCache.remove();
   System.out.println("removing: " + old);
   keyValue.remove(old);
  }
  ageCache.update(key, false);
  keyValue.put(key, value);
 }

 public void print() {
  System.out.println(keyValue);
 }
}
