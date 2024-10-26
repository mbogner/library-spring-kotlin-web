package dev.mbo.springkotlinweb

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [ModuleWebConfig::class])
internal open class ModuleWebConfig