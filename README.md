## Launch memcached

```
$ docker-compose up
```

## Launch Server

```
$ sbt
sbt> run
```

## curl

```
$ http POST localhost:9000/cache
HTTP/1.1 200 OK
Content-Length: 13
Content-Security-Policy: default-src 'self'
Content-Type: text/plain; charset=UTF-8
Date: Wed, 17 Oct 2018 14:19:04 GMT
Referrer-Policy: origin-when-cross-origin, strict-origin-when-cross-origin
X-Content-Type-Options: nosniff
X-Frame-Options: DENY
X-Permitted-Cross-Domain-Policies: master-only
X-XSS-Protection: 1; mode=block

User(John,12)

$ http localhost:9000/cache
HTTP/1.1 200 OK
Content-Length: 13
Content-Security-Policy: default-src 'self'
Content-Type: text/plain; charset=UTF-8
Date: Wed, 17 Oct 2018 14:19:36 GMT
Referrer-Policy: origin-when-cross-origin, strict-origin-when-cross-origin
X-Content-Type-Options: nosniff
X-Frame-Options: DENY
X-Permitted-Cross-Domain-Policies: master-only
X-XSS-Protection: 1; mode=block

User(John,12)
```


## telnet memchached

```
$ telnet localhost 11211

stats items
STAT items:4:number 1
STAT items:4:number_hot 0
STAT items:4:number_warm 0
STAT items:4:number_cold 1
STAT items:4:age_hot 0
STAT items:4:age_warm 0
STAT items:4:age 6
STAT items:4:evicted 0
STAT items:4:evicted_nonzero 0
STAT items:4:evicted_time 0
STAT items:4:outofmemory 0
STAT items:4:tailrepairs 0
STAT items:4:reclaimed 0
STAT items:4:expired_unfetched 0
STAT items:4:evicted_unfetched 0
STAT items:4:evicted_active 0
STAT items:4:crawler_reclaimed 0
STAT items:4:crawler_items_checked 0
STAT items:4:lrutail_reflocked 0
STAT items:4:moves_to_cold 1
STAT items:4:moves_to_warm 0
STAT items:4:moves_within_lru 0
STAT items:4:direct_reclaims 0
STAT items:4:hits_to_hot 0
STAT items:4:hits_to_warm 0
STAT items:4:hits_to_cold 0
STAT items:4:hits_to_temp 0
END
get defaultuser
VALUE defaultuser 1 82
srcontrollers.User[J.
                     IageLnametLjava/lang/String;xp
                                                   tJohn
END
```
