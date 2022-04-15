# 添加plugin
```
                <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>flatten-maven-plugin</artifactId>
                    <version>1.2.5</version>
                    <configuration>
                        <updatePomFile>true</updatePomFile>
                        <flattenMode>resolveCiFriendliesOnly</flattenMode>
                    </configuration>
                    <executions>
                        <execution>
                            <id>flatten</id>
                            <phase>process-resources</phase>
                            <goals>
                                <goal>flatten</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
```
# 将version版本替换为占位符
```
    <version>${reversion}</version>

    <properties>
        <reversion>1.0.0-DTC-SNAPSHOT</reversion>
    </properties>
```