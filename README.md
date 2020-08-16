# Redis Cache with Spring boot

<img src="/images/image.png" width="70%" height="30%" title="cache" alt="cache"></img>

```
$ redis-cli    

127.0.0.1:6379> FLUSHALL                                                                                                                                                              127.0.0.1:6379> flushall
127.0.0.1:6379> KEYS *
(empty list or set)

127.0.0.1:6379> KEYS *
1) "persons::\xea\xb0\x95\xec\x8a\xb9\xed\x98\xb8"  // after POST /create (one)

127.0.0.1:6379> keys * 
1) "persons::SimpleKey []" // after GET /read (all)
2) "persons::\xea\xb0\x95\xec\x8a\xb9\xed\x98\xb8"

127.0.0.1:6379> keys * // DELETE /delete (all)
(empty list or set)
```