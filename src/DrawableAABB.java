import com.jogamp.opengl.GL2;

public abstract class DrawableAABB extends AABB{
	private static final long serialVersionUID = 3616889993713688958L;
	private AnimationData ani;
	public DrawableAABB(int x, int y, int w, int h, AnimationData ani){
		super(x,y,w,h);
		this.ani = ani;
	}
	
	public void changeAnimation(AnimationData ani){
		this.ani = ani;
	}
	public void draw(Camera camera, GL2 gl, long deltaTimeMS){
		ani.update(deltaTimeMS);
		if(camera.AABBIntersect(this)){
			JavaTemplate.glDrawSprite(gl, this.ani.getCurrentImage(), this.getX()-camera.getX(), this.getY() - camera.getY(), this.getW(), this.getH());
		}
	}
}

abstract class DrawableAABBBuilder extends AABBBuilder{
	private AnimationData ani;
	public DrawableAABBBuilder() {}
	public DrawableAABBBuilder setAni(AnimationData ani) {this.ani = ani; return this;}
	public AnimationData getAni() {return this.ani;}
}
