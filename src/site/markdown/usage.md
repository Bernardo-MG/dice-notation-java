# Setting up the dependencies

The project files are hosted on [Bintray][bintray]. Acquiring them just requires setting up the dependency management tool being used.

---

## Maven

To use the library on Maven the Bintray repository should be added to the repositories in the POM:

```
<repositories>
	...
	<repository>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
		<id>bintray-tabletop-toolkits</id>
		<name>bintray</name>
		<url>http://dl.bintray.com/bernardo-mg/tabletop-toolkits</url>
	</repository>
	...
</repositories>
```

Then just add the dependency:
	
```
<dependencies>
	...
	<dependency>
		<groupId>com.wandrell.tabletop</groupId>
		<artifactId>dice</artifactId>
		<version>${tabletop.dice.version}</version>
	</dependency>
	...
</dependencies>
```

It is recommended to set the version through a property, as shown in the example.
	
## Gradle

It is possible to acquire the library through Gradle. For this, just add the repository:
	
```
repositories {
    maven {
        url  "http://dl.bintray.com/bernardo-mg/tabletop-toolkits" 
    }
}
```

Then just add the dependency:
	
```
dependencies {
	compile(group: 'com.wandrell.tabletop', name: 'dice', version: 'x.y.z')
}
```

Of course, the 'x.y.z' version should be set to the current one for the project.

[bintray]: https://bintray.com/bernardo-mg/tabletop-toolkits/dice/view}Bintray