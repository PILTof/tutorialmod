package net.pilto.tutorialmod.common.ai.entity.goal;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.pilto.tutorialmod.common.ai.entity.goal.attacks.PAbstractMeleeAttack;
import net.pilto.tutorialmod.common.entity.SoulessKnight;

import java.util.concurrent.TimeUnit;

public class PMeleeAttack extends PAbstractMeleeAttack {
    public PMeleeAttack(PathfinderMob pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
    }


    @Override
    protected void checkAndPerformAttack(LivingEntity pEnemy, double pDistToEnemySqr) throws InterruptedException {
        SoulessKnight.StartAttackTwoAnim = false;
        SoulessKnight.StartAttackOneAnim = false;
        double d0 = this.getAttackReachSqr(pEnemy);
        super.checkAndPerformAttack(pEnemy, pDistToEnemySqr);
        if (pDistToEnemySqr <= d0 && this.getTicksUntilNextAttack() <= 0) {
            this.resetAttackCooldown();
            if(count == 3)
                count -= 2;



            if(count == 1) {
                count++;
                SoulessKnight.StartAttackOneAnim = true;
                TimeUnit.MILLISECONDS.sleep(500);
                this.mob.doHurtTarget(pEnemy);
            }
            else if(count == 2) {
                count++;
                SoulessKnight.StartAttackTwoAnim = true;
                TimeUnit.MILLISECONDS.sleep(700);
                this.mob.doHurtTarget(pEnemy);
            }


        }
    }

    @Override
    protected void resetAttackCooldown() throws InterruptedException {
        this.ticksUntilNextAttack = 100;
        SoulessKnight.StartAttackOneAnim = false;
        SoulessKnight.StartAttackTwoAnim = false;

        TimeUnit.MILLISECONDS.sleep(200);
    }
}
