package designpatterns.creational;

import java.time.LocalDateTime;

public class FactoryExample {
    public static void main(String[] args) {
        FactoryClass factoryClass = new FactoryClass();
        Tenant tenant = factoryClass.createTenant(TenantType.INDIVIUAL);
        System.out.println(tenant);
        tenant = factoryClass.createTenant(TenantType.ORGANISATION);
        System.out.println(tenant);
        tenant = factoryClass.createTenant(null);
        System.out.println(tenant);
    }
}

interface Factory {
    Tenant createTenant(Enum type);
}

enum TenantType {
    INDIVIUAL,
    ORGANISATION,
    DEFAULT
}

abstract class Tenant {
    public TenantType tenantType;
    public LocalDateTime creationTime;

    @Override
    public String toString() {
        return "Tenant{" +
                "tenantType=" + tenantType +
                ", creationTime=" + creationTime +
                '}';
    }
}

class IndTenant extends Tenant {
    public IndTenant() {
        this.tenantType = TenantType.INDIVIUAL;
        this.creationTime = LocalDateTime.now();
    }
}

class OrgTenant extends Tenant {
    public OrgTenant() {
        this.tenantType = TenantType.ORGANISATION;
        this.creationTime = LocalDateTime.now();
    }
}

class DefualtTenant extends Tenant {
    public DefualtTenant() {
        this.tenantType = TenantType.DEFAULT;
        this.creationTime = LocalDateTime.now();
    }
}

class FactoryClass implements Factory {
    @Override
    public Tenant createTenant(Enum type) {
        Tenant tenant;
        if (type == TenantType.INDIVIUAL) {
            tenant = new IndTenant();
        } else if (type == TenantType.ORGANISATION) {
            tenant = new OrgTenant();
        } else {
            tenant = new DefualtTenant();
        }
        return tenant;
    }
}

