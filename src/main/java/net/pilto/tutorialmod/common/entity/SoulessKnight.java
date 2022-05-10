package net.pilto.tutorialmod.common.entity;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.pilto.tutorialmod.common.ai.entity.goal.PMeleeAttack;
import net.pilto.tutorialmod.common.ai.entity.goal.attacks.PAbstractMeleeAttack;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;


import javax.annotation.Nullable;

public class SoulessKnight extends Monster implements IAnimatable {

    //TODO =    ATTRIBUTES, GOALS
    public SoulessKnight(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));

        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(3, new PMeleeAttack(this, 1.0D, false));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

//    protected void CombatGoals() {
//        this.goalSelector.addGoal(7, new CustomMeleeAtack(this, 1.0d, false));
////        this.goalSelector.addGoal(7, new CustomRangedStrongAtack(this, 1.0d, false));
//    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().
                add(Attributes.FOLLOW_RANGE, 35.0D).
                add(Attributes.MAX_HEALTH, 98).
                add(Attributes.MOVEMENT_SPEED, (double) 0.17F).add(Attributes.ATTACK_DAMAGE, 3.0D).
                add(Attributes.ARMOR, 2.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }

    @Override
    public void setTarget(@Nullable LivingEntity pLivingEntity) {
        super.setTarget(pLivingEntity);
    }

    @Override
    public void tick() {
        super.tick();
    }


    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        return super.getCapability(capability, facing);
    }


//TODO =    GECKOLIB ANIMATIONS

    public AnimationFactory factory = new AnimationFactory(this);


    // walk and linivg animation
    private <E extends IAnimatable> PlayState predicate_living(AnimationEvent<E> event) {
        if (event.isMoving())
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.walk", true));
        else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.idle", true));

        return PlayState.CONTINUE;
    }



    //TODO =    ATTACK INICIALIZATIORS

    public static boolean StartAttackOneAnim = false;
    public static boolean StartAttackTwoAnim = false;

    //Attack One
    public <E extends IAnimatable> PlayState attackone(AnimationEvent<E> event) {
        if (StartAttackOneAnim) {


//                if(Minecraft.getInstance().player != null) {
//                    TextComponent chat = new TextComponent("AttackOne!!!");
//                    Minecraft.getInstance().player.sendMessage(chat, Minecraft.getInstance().player.getUUID());
//                }


            if (event.getController().getAnimationState() == AnimationState.Stopped) {
                event.getController().markNeedsReload();
            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.attackone", false));


        }

        return PlayState.CONTINUE;
    }


    //Attack Two
    public <E extends IAnimatable> PlayState attacktwo(AnimationEvent<E> event) {
        if (StartAttackTwoAnim) {

//            if(Minecraft.getInstance().player != null) {
//                TextComponent chat = new TextComponent("AttackTWOOOOO!!!");
//                Minecraft.getInstance().player.sendMessage(chat, Minecraft.getInstance().player.getUUID());
//            }


            if (event.getController().getAnimationState() == AnimationState.Stopped) {
                event.getController().markNeedsReload();
            }
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.attacktwo", false));


        }

        return PlayState.CONTINUE;
    }


    //TODO  =    #adding = add spawn animation.
    public static boolean SOULESS_KNIGHT_SPAWNED = false;

//    public <E extends IAnimatable> PlayState onSpawnAnimation(AnimationEvent<E> event) {
//
//
//        return PlayState.CONTINUE;
//    }



    //TODO =    REGISTER controllers
    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<SoulessKnight>(this, "controller", 0, this::predicate_living));
        data.addAnimationController(new AnimationController<SoulessKnight>(this, "attackonecontroller", 0, this::attackone));
        data.addAnimationController(new AnimationController<SoulessKnight>(this, "attacktwoncontroller", 0, this::attacktwo));


    }


    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }
}